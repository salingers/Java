import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ImageAlpha extends Applet
{
		final int Level = 10;
		int AlphaIndex = Level;
		Image src, chg;

		public void init()
		{
				src = getImage(getCodeBase(), "img.gif");
				chg = src;
				this.addKeyListener(new KeyAdapter()
				{
						public void keyPressed(KeyEvent ke)
						{
								switch (ke.getKeyCode())
								{

								case (KeyEvent.VK_DOWN):
										--AlphaIndex;
										if (AlphaIndex < 0)
												AlphaIndex = 0;
										filterImage();
										break;

								case (KeyEvent.VK_UP):
										++AlphaIndex;
										if (AlphaIndex > Level)
												AlphaIndex = Level;
										filterImage();
										break;
								}
						}
				});
		}

		public void paint(Graphics g)
		{
				g.drawImage(chg, 0, 0, this);
		}

		public void filterImage()
		{
				chg = src;
				chg = createImage(new FilteredImageSource(chg.getSource(), new ImgFilter((AlphaIndex * 255) / Level)));
				repaint();
		}
}

class ImgFilter extends RGBImageFilter
{
		int alphaIndex;

		public ImgFilter(int a)
		{
				alphaIndex = a;
				canFilterIndexColorModel = true;
		}

		public int filterRGB(int x, int y, int rgb)
		{
				int a = (rgb >> 24) & 0xff;
				a = (a * alphaIndex) / 255;
				return ((rgb & 0x00ffffff) | (a << 24));
		}
}
