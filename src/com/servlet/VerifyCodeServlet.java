package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyCodeServlet extends HttpServlet {

	//验证图片的宽度
	private final int width = 70;
	//验证图片的高度
	private final int height = 30;
	//验证码字符的个数
	private final int codeCount = 4;
	//字体高度
	private int fontHeight;
	
	private int xx = 0;
	private int codeY;
	
	String[] codeSequence = { "1" , "2" , "3" , "4" , "5" ,"6","7","8","9","A","a","B","b","c","C"
		       ,"D","d","E","e","F","f","G","g","z","X","Q","v"};
	
	public VerifyCodeServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("It's VerifyCodeServlet!");
		
		HttpSession session = request.getSession();
		
		//定义图像buffer
		BufferedImage buffImg = new BufferedImage(width,height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D gd = buffImg.createGraphics();
		
		//创建一个随机数发生器
		Random random = new Random();
		
		//将图像填充成白色
		gd.setColor(Color.white);
		gd.fillRect(0, 0, width, height);
		
		//创建字体
		Font font = new Font("Fixedsys",Font.PLAIN, fontHeight);
		//设置字体
		gd.setFont(font);
		
		//边框
		gd.setColor(Color.black);
		gd.drawRect(0, 0, width-1, height-1);
		
		//随机画4条干扰线
		gd.setColor(Color.black);
		for(int i=0;i<4;i++){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}
		
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
	    StringBuffer randomCode = new StringBuffer();
	    int red = 0, green = 0, blue = 0;
	    
	    //随机生成codeCount个验证码
	    for(int i=0;i<codeCount;i++){
	    	// 得到随机产生的验证码数字。
	        String strRand = String.valueOf(codeSequence[random.nextInt(27)]);
	        // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
	        red = random.nextInt(125);
	        green = random.nextInt(255);
	        blue = random.nextInt(200);
	    
	        // 用随机产生的颜色将验证码绘制到图像中。
	        gd.setColor(new Color(red, green, blue));
	        gd.drawString(strRand, (i + 1) * xx, codeY);
	    
	        // 将产生的四个随机数组合在一起。
	        randomCode.append(strRand);
	    }
	    
	    
	    
	    // 禁止图像缓存。
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    response.setContentType("image/jpeg");
	    
	    //将图像输出到输出流
	    ServletOutputStream sos = response.getOutputStream();
	    ImageIO.write(buffImg, "jpeg", sos);
	    sos.close();
	    
	   // 将四位数字的验证码保存到Session中
	  session.setAttribute("verification", randomCode.toString());
	  System.out.println("verification:"+randomCode.toString());
	  //验证码有效时间120s
	  session.setMaxInactiveInterval(120);
	   
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		//生成随机数的水平距离
		xx = width/(codeCount+3);
		//生成随机数的数字高度
		fontHeight = height - 2;
		//生成随机数的垂直距离
		codeY = height - 8;
	}

}
