package applet;

import java.awt.*;
import java.applet.*;

public class Tracker extends Applet implements Runnable
{
	Image[] image; // 影像陣列
	int cur; // 目前影像
	MediaTracker mt; // 媒體架
	int delay = 100; // 延遲時間(毫秒)
	Thread thread = null; // 執行緒

	public void init() // 初始狀況
	{
		mt = new MediaTracker(this); // 建立媒體架物件
		image = new Image[10]; // 建立影像陣列
		for (int i = 0; i <= 9; i++) // 影像逐一處理
		{
			image[i] = getImage(getDocumentBase(), "pic" + i + ".jpg");
			mt.addImage(image[i], i); // 擺上媒體架i
		}
	}

	public void start() // 啟動
	{
		thread = new Thread(this); // 建立執行緒
		thread.start(); // 啟動此執行緒
	}

	public void stop() // 停止
	{
		thread = null; // 執行緒空白
	}

	public void run() // 執行
	{
		for (int i = 0; i <= 9; i++) // 每個影像逐一處理
		{
			showStatus("載入圖片" + i); // 顯示載入第i影像中
			try
			{
				mt.waitForID(i);
			} // 等待載入完畢
			catch (InterruptedException e)
			{
			}
			; // 例外時
			if (mt.isErrorID(i)) // 載入時發現錯誤
			{
				showStatus("Loading image " + i + " error!"); // 錯誤
				return; // 結束
			}
		}

		showStatus("載入成功"); // 載入成功
		while (true) // 無窮迴圈
		{ // 目前影像超過時
			if (++cur >= image.length)
				cur = 0; // 從頭來過
			getGraphics().drawImage(image[cur], 0, 0, this);
			try
			{
				Thread.sleep(delay);
			} // 休息delay毫秒
			catch (InterruptedException e)
			{
			}
			; // 例外時
		}
	}

}
