package gui;

import javax.swing.JLabel;

/**
 * @author jmccormi Some code borrowed from
 * http://www.java2s.com/Code/Java/Swing-JFC/Animationlabel.htm Class to animate
 * a JLabel for the net loading screen
 */
public class AnimatedLabel extends JLabel implements Runnable
{
	public AnimatedLabel()
	{
		setText("Waiting");
		new Thread(this).start();
	}

	/**
	 * Runs the thread which causes the net loading screen to have an animated
	 * "Waiting" JLabel
	 */
	@Override
	public void run()
	{
		m_isFinished = false;
		while (!m_isFinished)
		{
			m_stringIndex++;
			if (m_stringIndex == 1)
			{
				setText("Waiting. ");
			}
			else if (m_stringIndex == 2)
			{
				setText("Waiting.. ");
			}
			else
			{
				setText("Waiting... ");
				m_stringIndex = 0;
			}
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception ex)
			{
			}
		}
	}

	private static final long serialVersionUID = 7373349083032786721L;

	public static boolean m_isFinished = false;

	protected String[] m_strings;
	protected int m_stringIndex = 0;
}
