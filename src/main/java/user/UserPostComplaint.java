package user;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

import com.oreilly.servlet.MultipartFilter;

/**
 * Servlet implementation class regForm
 */

public class UserPostComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPostComplaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
		String uid,cid,state,loc,street,phno,posttitle,department,postdesc;
		String imagepath=null;
		Enumeration e=null;
		MultipartFormDataRequest mfr = null;
		UploadBean upb=null;
		response.setContentType("text/html");

		Hashtable fi;
		Date date = new Date();
		//Document doc=new Document();

		System.out.println("userpost called.....");
		try {
			upb=new UploadBean();
			mfr=new MultipartFormDataRequest(request);
			uid=mfr.getParameter("uid");
			cid = generateUserCode();
			System.out.println(cid);
			state= mfr.getParameter("state");
			System.out.println(state);
			loc = mfr.getParameter("loc");
			street = mfr.getParameter("street");
			phno = mfr.getParameter("mbno");
		
		
			posttitle = mfr.getParameter("posttitle");
			department = mfr.getParameter("department");
			postdesc = mfr.getParameter("postdesc");
			fi=mfr.getFiles();
			upb.setFolderstore("C:\\Users\\tcshydisuser\\Desktop\\998102\\Sample\\WebContent\\images");
			upb.store(mfr);
			
			Hashtable ht= mfr.getFiles();
			      e=ht.elements();
			while(e.hasMoreElements())
			{
				UploadFile file= (UploadFile) e.nextElement();
				imagepath=file.getFileName();
			} 
			String path;
			Complaintformbean rb=new Complaintformbean();
			int st=rb.storePosts(uid,cid, state, loc, street,phno,posttitle,department,postdesc,imagepath);
			if(st>0){
				/*doc.open();
				String fname="complaint_"+cid;
				path="C:\\Users\\tcshydisuser\\Desktop\\998102\\Sample\\WebContent\\complaints\\"+fname+".pdf";
				PdfWriter.getInstance(doc,new FileOutputStream(path));
				doc.open();
				System.out.println("path is:"+path);
				doc.add(new Paragraph("UserId:"+uid+"\n"));
				doc.add(new Paragraph("MobileNo:"+phno+"\n"));
				doc.add(new Paragraph("Location:"+loc+"\n"));
				doc.add(new Paragraph("_____________________________________________________________________________\n"));
				doc.add(new Paragraph("ComplaintId :"+cid+"\n"));
				doc.add(new Paragraph("Department :"+department+"\n"));
				doc.add(new Paragraph("PostTitle: "+posttitle+"\n"));
				doc.add(new Paragraph("Post Description: \n"+postdesc+"\n"));
				doc.add(new Paragraph("Happy To Help Any Complaints!!!!!!!!!!!!!!!!!!!\n"));	
			    doc.close();*/
			    request.getSession().setAttribute("comp",cid);
			    //pw.println("window.open('PostComplaintDisplay.jsp')");
			    rd=request.getRequestDispatcher("/PostComplaintDisplay.jsp");
			    rd.forward(request, response);
			}
			else{
				rd=request.getRequestDispatcher("/UserPostComplaint.jsp");
				rd.forward(request, response);
			}
			
		}
		catch (UploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//PrintWriter out=response.getWriter();
		
	


	
	}

	private String generateUserCode() {
		// TODO Auto-generated method stub
        String gcode="";
        String range="0123456789";
        StringBuffer gencode=new StringBuffer();
        for(int i=0;i<3;i++){
                gencode.append(range.charAt((int) (Math.random()*(range.length()))));
        }
        gcode="Comp"+gencode.toString();
        System.out.println("genecode: "+gcode);
    return gcode;
		
	}
	
}
