package com.ecommerce.bicicle.constants;

public class EmailContent {

    public static final String MAIL_FROM =  "rider911@baaw.mx";

    public static final String MAIL_SUBJECT_BUYER =  "BAAW - Notificacion de Compra";
    public static final String MAIL_SUBJECT_VENDOR =  "BAAW - Notificacion de Venta";
    public static final String MAIL_SUBJECT_ADMINS =  "BAAW Partener - Notificacion de Compra/Venta ";

    public static final String MAIL_TOKEN_BUYER_LINK = "${buyerLink}";
    public static final String MAIL_TOKEN_ITEM_ID = "${itemId}";
    public static final String MAIL_TOKEN_ADMIN_CONSOLE_LINK = "${adminConsole}";
    public static final String MAIL_TOKEN_TRANSACTION_ID = "${transactionId}";
    public static final String MAIL_TOKEN_TRANSACTION_DATE = "${transactionDate}";
    public static final String MAIL_TOKEN_CLIENT_NAME = "${clientName}";
    public static final String MAIL_TOKEN_UPLOAD_VENDOR = "${uploadVendor}";

    public static final String MAIL_TOKEN_USER_NOTIFIC = "${userNotification}";
    public static final String MAIL_TOKEN_ = "${}";
    public static final String MAIL_TOKEN_SENT_TIME = "${mailSentTime}";
    public static final String MAIL_TOKEN_ITEM_COMMENTS = "${itemComments}";
    //

    //UPLOAD SUBJECT
    public static final String MAIL_BODY_UPLOAD_ADMIN_SUBJECT = "Bicicleta agreagda a Baaw";
    public static final String MAIL_BODY_UPLOAD_VENDOR_SUBJECT = "Bicicleta agregeda a Baaw";

    //UPLOAD MESSAGE
    public static final String MAIL_BODY_UPLOAD_ADMIN_MESSAGE = "El usuatio con el nombre " + MAIL_TOKEN_UPLOAD_VENDOR + " ha subido un nuevo item <br> " + " Dirijase a la consola de administracion para diagnosticar el Item: " + MAIL_TOKEN_ADMIN_CONSOLE_LINK;
    public static final String MAIL_BODY_UPLOAD_VENDOR_MESSAGE = "Se ha agregado de manera exitosa la Bicicleta <br> " + "Nuestros Expertos estan en el proceso de evaluar tu bicicleta, espera su notificacion";

    //DIAGNOST ADMIN SUBJECT
    public static final String MAIL_BODY_DIAGNOST_ADMIN_DECLINE_SUBJECT = "Bicicleta Delicnada por Baaw Partner ";
    public static final String MAIL_BODY_DIAGNOST_ADMIN_ACCEPTED_SUBJECT = "Bicicleta Aceptada por Baaw Partner ";

    //DIAGNOST VENDOR SUBJECT
    public static final String MAIL_BODY_DIAGNOST_VENDOR_DECLINE_SUBJECT = "Su Bicicleta no ha pasado el diagnostico";
    public static final String MAIL_BODY_DIAGNOST_VENDOR_ACCEPTED_SUBJECT = "Su Bicicleta Ha sido agregada a la tienda de Baaw";

    //DIAGNOST VENDOR MESSAGE
    public static final String MAIL_BODY_DIAGNOST_VENDOR_DECLINE_MESSAGE = "Despues de un proceso de validacion, con nuestros expertos en ciclismo <br> " + "hemos tomado la decision de declinar la bicicleta que haz agregado al Market place. <br><br>" +  "Estas son las observaciones que ha recibido tu bicicleta: <br> "+MAIL_TOKEN_ITEM_COMMENTS+" <br>";
    public static final String MAIL_BODY_DIAGNOST_VENDOR_ACCEPTED_MESSAGE = "Despues de un proceso de validacion, queremos informarte que" +  "Se ha agregado de manera exitosa la Bicicleta a nuestro Market Place <br>";

    //DIAGNOST ADMIN MESSAGE
    public static final String MAIL_BODY_DIAGNOST_ADMIN_DECLINE_MESSAGE = "Despues de un proceso de validacion, con nuestros expertos en ciclismo <br> " + "hemos tomado la decision de declinar la bicicleta que haz agregado al Market place. <br><br>" +  "Estas son las observaciones que ha recibido tu bicicleta: <br> "+MAIL_TOKEN_ITEM_COMMENTS+" <br>";
    public static final String MAIL_BODY_DIAGNOST_ADMIN_ACCEPTED_MESSAGE = "Despues de un proceso de validacion, queremos informarte que" +  "Se ha agregado de manera exitosa la Bicicleta a nuestro Market Place <br>";

    // PURCHASE SUBJECT
    public static final String MAIL_BODY_PURCAHSE_BUYER_SUBJECT = "";
    public static final String MAIL_BODY_PURCAHSE_VENDOR_SUBJECT = "";
    public static final String MAIL_BODY_PURCAHSE_ADMIN_SUBJECT = "";

    // PURCHASE MESSAGE
    public static final String MAIL_BODY_PURCAHSE_BUYER_MESSAGE = "Su compra ha sido efectuda, para el producto "+MAIL_TOKEN_BUYER_LINK+", para mas informacion consulte el siguiente enlace";
    public static final String MAIL_BODY_PURCAHSE_VENDOR_MESSAGE = "Su articulo ha sido Comprado, por favor siga las intrucciones para recibir su deposito lo antes posible";
    public static final String MAIL_BODY_PURCAHSE_ADMIN_MESSAGE = "Se ha efectuado una transaccion del articulo con el id "+MAIL_TOKEN_ITEM_ID+", " + "consulte la consola de adminstracion de ventas para mayor informacion: <br>" +  MAIL_TOKEN_ADMIN_CONSOLE_LINK;

    // SEND TO BAAW PARTNER SUBJECT
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_BUYER_SUBJECT = "La Bicicleta ha sido enviada a un Baaw Partner para otorgarle el servicio de Lavado y Empaquetado";
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_VENDOR_SUBJECT = "Ha entregado la bicileta al Baaw partner";
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_ADMIN_SUBJECT = "Se ha recibido la bicicleta del Usuario " + MAIL_TOKEN_UPLOAD_VENDOR + " a la sucursal del Baaw Partner ";

    // SEND TO BAAW PARTNER MESSAGE
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_BUYER_MESSAGE = "";
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_VENDOR_MESSAGE = "";
    public static final String MAIL_BODY_SENT_BAAW_PARTNER_ADMIN_MESSAGE = "";

    // SERVICE SUBJECT
    public static final String MAIL_BODY_SERVICE_BUYER_SUBJECT = "Notificacion de Servicio a bicicleta";
    public static final String MAIL_BODY_SERVICE_VENDOR_SUBJECT = "Notificacion de Servicio a bicicleta";
    public static final String MAIL_BODY_SERVICE_ADMIN_SUBJECT = "Notificacion de Servicio a bicicleta";

    // SERVICE MESSAGE
    public static final String MAIL_BODY_SERVICE_BUYER_MESSAGE = "Se ha finalizado el servio de lavado y empaquetado";
    public static final String MAIL_BODY_SERVICE_VENDOR_MESSAGE = "Se ha finalizado el servio de lavado y empaquetado";
    public static final String MAIL_BODY_SERVICE_ADMIN_MESSAGE = "Se le ha notificado al vendedor y comprador que la bicilceta ha finalizado su servicio y empaquetado";

    // SEND TO BUYER SUBJECT
    public static final String MAIL_BODY_SEND_TO_BUYER_BUYER_SUBJECT = "Notificacion de envio";
    public static final String MAIL_BODY_SEND_TO_BUYER_VENDOR_SUBJECT = "Notificacion de envio";
    public static final String MAIL_BODY_SEND_TO_BUYER_ADMIN_SUBJECT = "Notificacion de envio";

    // SEND TO BUYER MESSAGE
    public static final String MAIL_BODY_SEND_TO_BUYER_BUYER_MESSAGE = "Se ha enviado la bicicleta que compraste";
    public static final String MAIL_BODY_SEND_TO_BUYER_VENDOR_MESSAGE = "Se ha enviado la bicicleta que vendiste";
    public static final String MAIL_BODY_SEND_TO_BUYER_ADMIN_MESSAGE = "Se notifico al comprador que su bicicleta <br >Se enviado la bicicleta por medio de paqueteria al destinatario";

    // RECEIVED SUBJECT
    public static final String MAIL_BODY_RECEIVED_BUYER_SUBJECT = "Notificacion de Bicileta Recibida por el comprador";
    public static final String MAIL_BODY_RECEIVED_VENDOR_SUBJECT = "Notificacion de Bicileta Recibida por el comprador";
    public static final String MAIL_BODY_RECEIVED_ADMIN_SUBJECT = "Notificacion de Bicileta Recibida por el comprador";

    // RECEIVED MESSAGE
    public static final String MAIL_BODY_RECEIVED_BUYER_MESSAGE = "Haz recibido tu bicicleta, Felicidades";
    public static final String MAIL_BODY_RECEIVED_VENDOR_MESSAGE = "La bicileta que vendiste ha sido recibida. <br> Tu deposito va en camino";
    public static final String MAIL_BODY_RECEIVED_ADMIN_MESSAGE = "La bicileta ha sido recibida por el comprador";

    public static final String MAIL_BODY_UPLOAD_ITEM_HEADER =
            "<table style='width: 100%; font-family: Montserrat '>" +
                    "    <tr>" +
                    "        <td> </td>" +
                    "        <td>" +
                    "        <img src='cid:logo'>" +
                    "        </td>" +
                    "        <td style='float: right; font-size: 1.5em;' colspan='1'>" +
                    "            Fecha del correo: " + MAIL_TOKEN_SENT_TIME +
                    "        </td>" +
                    "    </tr>";

    public static final String MAIL_BODY_PURCAHSE_HEADER =
            "<table style='width: 100%; font-family: Montserrat '>" +
            "    <tr>" +
            "        <td> </td>" +
            "        <td>" +
            "        <img src='cid:logo'>" +
            "        </td>" +
            "        <td style='float: right; font-size: 1.5em;' colspan='1'>" +
            "            Id de Transacction: " + MAIL_TOKEN_TRANSACTION_ID +
            "            <br>" +
            "            Fecha de transaccion: " + MAIL_TOKEN_TRANSACTION_DATE +
            "        </td>" +
            "    </tr>";

    public static final String MAIL_BODY_PURCAHSE_FOOTER =
                    "</table>" +
                    "<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>";

    public static final String MAIL_BODY_VENDOR_STEPS =
            "    <tr  style='font-family: Montserrat; font: caption;'>" +
            "        <td colspan='2'>" +
            "            Para continuar con su Proceso de venta, cumpla estos requisitos:" +
            "        </td>" +
            "        <td></td>" +
            "    </tr>" +
            "    <tr style='height: 30px; font-family: Montserrat; font-size: 1.5em;'>" +
            "        <td colspan='3'>" +
            "            <ol style='line-height: 2em'>" +
            "                <li>" +
            "                    Una vez vendida tu bicicleta tendrás que visitar a uno de nuestros Baaw socios quien dará servicio"+
            "                    completo, diagnóstico y embalaje correcto para enviar tu bicicleta de manera adecuada. Si no tienes"+
            "                    uno favor de contactarnos." +
            "                </li>" +
            "                <li>" +
            "                    Dar un servicio completo a tu bicicleta antes de enviar, ya que esto puede ser causa de que tu"+
            "                    comprador no esté satisfecho con su compra y devolverla. Esto implicaría un gasto extra para ti porque"+
            "                    el cargo corre por tu cuenta. Recuerda que tu como vendedor debes de dar la mejor impresión de tu"+
            "                    producto." +
            "                </li>" +
            "                <li>" +
            "                    No hacer ningún cambio o modificación a la bicicleta publicada, recuerda que el comprador espera"+
            "                    recibir tal cual como la vio en el portal." +
            "                </li>" +
            "            </ol>" +
            "        </td>" +
            "    </tr>";

    public static final String MAIL_BODY_PURCAHSE_NOTIFICATION =
        "    <tr>" +
        "        <td>" +
        "            <h1>Estimad@ " + MAIL_TOKEN_CLIENT_NAME + " </h1>" +
        "        </td>" +
        "        <td></td>" +
        "        <td></td>" +
        "    </tr>" +
        "    <tr>" +
        "        <td style='height: 60px; font-size: 1.5em;' colspan='2'>" +
        "        Le enviamos este correo para notificarle lo siguiente:" +
        "            <br>" +
                MAIL_TOKEN_USER_NOTIFIC +
        "        </td>" +
        "        <td></td>" +
        "    </tr>";

    public static final String MAIL_FONT_FAMILY =
            "<style>" +
            "li{" +
            "  margin: 10px 0;" +
            "}" +
            "</style>";
}
