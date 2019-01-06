<?php

    $destinatarios = 'tulio.pompeu@gmail.com';
    $nomeDestinatario = 'Túlio César Pompeu';
    $usuario = 'tulio@jandiraccb.com.br';
    $senha = 'gabriela!001';

    /*abaixo as veriaveis principais, que devem conter em seu formulario*/
    $nomeRemetente = 'Informática - Jandira CCB'; //$_POST['nomeRemetente'];
    $assunto = 'Abertura de Solicitação'; //$_POST['assunto'];

    /*********************************** A PARTIR DAQUI NAO ALTERAR ************************************/

    include_once("class.phpmailer.php");

    $To = $destinatarios;
    $Subject = $assunto;
    $Message = 'Abertura de chamado';

    $Host = 'smtp.'.substr(strstr($usuario, '@'), 1);
    $Username = $usuario;
    $Password = $senha;
    $Port = "587";

    $mail = new PHPMailer();
    $body = $Message;
    $mail->IsSMTP(); // telling the class to use SMTP
    $mail->Host = $Host; // SMTP server
    $mail->SMTPDebug = 0; // enables SMTP debug information (for testing)
    // 1 = errors and messages
    // 2 = messages only
    $mail->SMTPAuth = true; // enable SMTP authentication
    $mail->Port = $Port; // set the SMTP port for the service server
    $mail->Username = $Username; // account username
    $mail->Password = $Password; // account password

    $mail->SetFrom($usuario, $nomeDestinatario);
    $mail->Subject = $Subject;
    $mail->MsgHTML($body);
    $mail->AddAddress($To, "");

    if(!$mail->Send()) {
        echo "<script language=javascript> alert('Erro ao enviar e-mail !!!'),window.location='listaSolicitacaoInformatica.php';</script>";
    } else {
        echo "<script language=javascript> alert('E-mail enviado com sucesso !!!'),window.location='listaSolicitacaoInformatica.php';</script>";
    }

?>