<%@ page language="java" contentType="image/jpeg;charset=GB2312"
import="java.util.*,java.awt.*,java.awt.geom.*"
import="java.awt.image.*,com.sun.image.codec.jpeg.*"
%>
<%
  int width=600,height=500;
  BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
  Graphics g=image.getGraphics();
  Graphics2D g2d=(Graphics2D) g;
  g.setColor(new Color(240,249,255));
  g.fillRect(0,0,width,height);
  g.setColor(Color.white);
  g.drawRect(10,35,width-20,height-46);
  g.setColor(Color.black);
  g.setFont(new Font("华文新魏",Font.PLAIN,22));
  g.drawString("水果销售情况图表  JSP版（折线图）  网友提供",15,25);
  int book_sales[]=new int[5];
  for(int i=0;i<book_sales.length;i++){
  book_sales[i]=1+(int)(Math.random()*100);
  }
  String book_title[]={"苹果","香蕉","荔枝","猕猴桃","葡萄"};
  Color color[]=new Color[5];
  color[0]=new Color(99,99,0);
  color[1]=new Color(255,169,66);
  color[2]=new Color(33,255,66);
  color[3]=new Color(33,0,255);
  color[4]=new Color(255,0,66);
  g.setFont(new Font("华文行楷",Font.BOLD,16));
  g.drawString("销售量",20,50);
  g.drawString("水果分类",500,465);
  g.setFont(new Font("SanSSerif",Font.PLAIN,12));
  int salesValue=0;
  for(int i=418;i>0;i-=38){
    g.setColor(Color.black);
g.drawString(""+salesValue,36,(i+27));
g.setColor(Color.lightGray);
g.drawLine(80,(i+27),520,(i+27));
salesValue+=10;
  }
  g.setColor(Color.black);
  g.drawLine(80,40,80,445);
  g.drawLine(80,445,550,445);
  int drawHigh[]=new int[book_title.length];
  int drawwidth[]=new int[book_title.length];
  for(int i=0;i<book_title.length;i++){
    drawHigh[i]=445-(int)(Math.ceil(book_sales[i]*3.8));
drawwidth[i]=110+i*80;
g.setColor(color[i]); 
g.fillOval(drawwidth[i]-7,drawHigh[i]-7,14,14);
g.setColor(Color.black);
g.drawString(book_title[i],110+i*80,465);
  }
  g2d.setXORMode(Color.white);
  g2d.setStroke(new BasicStroke(4.0f));
  g2d.setPaint(Color.red);
  g2d.drawPolyline(drawwidth,drawHigh,book_title.length);
  g.dispose();
  ServletOutputStream sos=response.getOutputStream();
  JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(sos);
  encoder.encode(image);
%>
