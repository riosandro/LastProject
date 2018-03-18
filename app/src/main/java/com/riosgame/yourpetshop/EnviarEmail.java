package com.riosgame.yourpetshop;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInstaller;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Config;
import android.view.View;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static javax.mail.Message.RecipientType.TO;

/**
 * Created by Jose on 3/17/2018.
 */

public class EnviarEmail extends AsyncTask <Void,Void,Void>{
    //declaro las variables
    private Context context;
    private Session session;

    //Informacion para enviar en Email
    private String email;
    private String nombre;
    private String mensagec;
    private String telefono;

    //implemento un progressdialog
    private ProgressDialog progressDialog;

    //implemnto la clase constructora
    public EnviarEmail(Context context, String email, String nombre, String mensagec,String telefono){
        //Inizio las variables
        this.context = context;
        this.email = email;
        this. nombre = nombre;
        this.mensagec = mensagec;
        this.telefono = telefono;
    }
    @Override
    protected  void onPreExecute(){
        super.onPreExecute();
        //Mostramos en progressdialog
        progressDialog = ProgressDialog.show(context, "El mensage se esta enviando", "Por favor espere...",false,false);

    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        //ocultamos en ProgressDialog
        progressDialog.dismiss();
        //Mostramos un toast con un mensage de enviado
        Toast.makeText(context, "Mensage enviado", Toast.LENGTH_LONG).show();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        //Creamos las propiedades
        Properties props = new Properties();
        //Configuramos las propiedades para en email
        //Si usamos otro correo que no sea gmail tenemos que cambiar los valores
        props.put("mail.smpt.host", "smtp.gmail.com");
        props.put("mail.smpt.socketFactory.port", "465");
        props.put("mail.smpt.ocketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smpt.auth", "true");
        props.put("mail.smpt.port", "465");
        //Creamos una nueva session
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            //Autenticamos la clave de email
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ImailConfig.EMAIL, ImailConfig.PASSWORD);
            }
        });
        try {
            MimeMessage mm = new MimeMessage(session);
            //configuramos la direccion del que envia
            mm.setFrom(new InternetAddress(ImailConfig.EMAIL));
            //Agregamos la direccion del que recive
            mm.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(email)});
            //Agregamos el subject
            mm.setSubject(nombre);
            //Agregamos el telefono
            mm.setText(telefono);
            //agregamos el mensage
            mm.setText(mensagec);
            //enviamos el mensage
            Transport.send(mm);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
//}
