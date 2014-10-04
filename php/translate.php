<?php

    if(empty($_GET["to"]) == true || empty($_GET["text"]) == true) {
        die('Empty GET key "to" or "text".');
    }


    $data = array(
        "from" => empty($_GET["from"]) ? "auto" : $_GET["from"],
        "to" => $_GET["to"],
        "text" => urlencode($_GET["text"])
    );

    $ch = curl_init(); 

    curl_setopt($ch,CURLOPT_URL,"translate.google.com/translate_a/t?client=p&text=" . $data["text"] . "&sl=" . $data["from"] . "&tl=" . $data["to"] . "&ie=UTF-8&oe=UTF-8&multires=1&otf=1&pc=1&trs=1&ssel=3&tsel=6&sc=1");
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
    curl_setopt($ch,CURLOPT_USERAGENT, "");

    $json = json_decode(curl_exec($ch));
    echo $json->{"sentences"}[0]->{"trans"};
?>



