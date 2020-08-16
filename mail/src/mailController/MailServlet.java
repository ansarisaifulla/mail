package mailController;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public MailServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("forgotPass.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		String mail = request.getParameter("forgotmail");

		try {
		
				Random rand = new Random();
	    		int otp = rand.nextInt(900000) + 100000;
	    	
	    		// Sender's email ID needs to be mentioned
	    		String from = "ansarisaifulla7@gmail.com";

	    		// Assuming you are sending email from localhost
	    		String host = "smtp.gmail.com";

	    		// Get system properties
	    		Properties properties = System.getProperties();

	    		// Setup mail server
	    		properties.setProperty("mail.smtp.host", host);
	    		properties.setProperty("mail.transport.protocol", "smtp");
	    		properties.setProperty("mail.smtp.auth", "true");
	    		properties.setProperty("mail.smtp.starttls.enable", "true");
	    		properties.setProperty("mail.user", from);
	    		properties.setProperty("mail.password", "xavier123");
	    		properties.setProperty("mail.port", "465");
	    		
	    		Session session2 = Session.getInstance(properties, new javax.mail.Authenticator(){
	    			@Override
	    			protected PasswordAuthentication getPasswordAuthentication(){
	    				return new PasswordAuthentication(from,"xavier123");
	    			}
	    		});
	    		MimeMessage message = new MimeMessage(session2);

	    		   // Set From: header field of the header.
	    		   message.setFrom(new InternetAddress(from));

	    		   // Set To: header field of the header.
	    		   message.addRecipient(Message.RecipientType.TO,
	    		                            new InternetAddress(mail));

	    		   // Set Subject: header field
	    		   message.setSubject("Verification code to reset your password");

	    		   // Now set the actual message
	    		   message.setText("Your one time otp for resetting your password is : "+otp+"\n\n If not made by you, Please don't share this otp with anyone else.");

	    		   // Send message
	    		   Transport.send(message);
	    		   System.out.println("OTP message sent successfully....");
	    		   response.sendRedirect(request.getContextPath() + "/VerifyForgotPass");
			
			
		} 
		catch (MessagingException mex) {
	 		   mex.printStackTrace();
	 	} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
