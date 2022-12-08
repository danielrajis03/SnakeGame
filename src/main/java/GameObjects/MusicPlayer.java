package GameObjects;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

/**
 * Public class will be called everytime I need to implement music in the game.
 */
public class MusicPlayer extends Thread
{
	/**
	 * Will hold the directory of the music being fetched.
	 */
	private String filename;

	public Player player;

	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

	public void play()
	{
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				try
				{

					player =
						new Player(new BufferedInputStream(new
							FileInputStream(filename)));
					player.play();

				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}


	/**
	 * @param filename
	 * @Description Gets Music by getting it from a source root
	 */
	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
