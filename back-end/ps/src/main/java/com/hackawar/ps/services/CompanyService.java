package com.hackawar.ps.services;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.hackawar.ps.domain.company.dto.CompanyDto;

@Service
public class CompanyService {

    public void sendCompanyToEmail(CompanyDto companyDto) {

        String host = "smtp.gmail.com";
        String porta = "587"; 
        String usuario = "ecoponto.co@gmail.com";
        String senha = "ihyp oumq gstc exce";
        String destiny = companyDto.email();

        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", porta);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        });

        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destiny));
            message.setSubject(companyDto.companyName());
            message.setText("A empresa de nome: " + companyDto.companyName() + " deseja contato no telefone: " + companyDto.telephone());

            Transport.send(message);

            System.out.println("Email enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
