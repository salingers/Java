import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ShowWord extends Applet
{ // 繼承Applet類別
	String s; // 宣告一個字串，用來顯示的訊息

	public void init()
	{ // Applet的初始化方法
		s = getParameter("ShowString"); // 從.HTML中取得名為ShowString的參數
		s = "Java & NKNU"; // 如果參數不存在，就直接給字串內容。
	}

	public void paint(Graphics g)
	{ // 在Applet上畫畫用的方法
		// Graphics為畫圖類別，paint方法需要傳入此類物件
		int swidth, sheight; // 定義兩個變數，用來存字串的長和寬

		Font f = new Font("Dialog", Font.BOLD + Font.ITALIC, 24);
		// 利用Font類別定義一個字形物件，並給內容
		FontMetrics fm = g.getFontMetrics(f);
		// FontMetrics 類別為輔助用，用來幫忙取的字形的細部內容
		swidth = fm.stringWidth(s); // 取得寬
		sheight = fm.getHeight(); // 取得長

		int maxx = getSize().width; // 定義變數，取得目前視窗寬度
		int maxy = getSize().height; // 定義變數，取得目前視窗長度

		g.setColor(Color.blue); // 設定劃筆顏色
		g.fillRect(0, 0, maxx, maxy); // 將整個畫面圖滿
		// fileRect方法為畫矩形用
		g.setFont(f); // 設定字形，將之前定義的字型物件傳入
		g.setColor(Color.orange); // 另設劃筆顏色
		g.drawString(s, (maxx - swidth) / 2, (maxy + sheight) / 2);
		// 將字串放在視窗中間
		g.drawOval(0, 0, maxx, maxy); // 畫個橢圓
		g.drawOval(1, 1, maxx - 2, maxy - 2); // 再畫個橢圓，增加厚度
		g.drawOval(2, 2, maxx - 4, maxy - 4); // 又畫個橢圓，增加厚度
	}
}
