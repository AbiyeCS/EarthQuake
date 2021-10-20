/**
 * Program to display earthquake details from a USGS data feed.
 *
 * <p>The required feed is specified by supplying a significance level
 * and time period as command line arguments.</p>
 */
public class QuakeInfo
{

  public static void main(String[] args)
  {
    String level = args[0];
    String period = args[1];

    if(!isLevelValid(level))
    {
			System.out.println("You have entered the level incorrectly, please see valid levels below and try again");
			System.out.println("'significant', '4.5', '2.5', '1.0' and 'all'");
			return;
		}//making sure user puts in correct level

		if(!isPeriodValid(period))
    {
			System.out.println("You have entered the time period incorrectly, please see valid time periods and try again");
			System.out.println("Valid periods are 'hour', 'day', 'week' or 'months'.");
			return;
		} //Making sure user puts in correct time period

    QuakeFeed qF = new QuakeFeed(level, period);

    qF.update();

//Below I output details of strongest, weakest, deepest and most depthless quakes
    Quake minQua = qF.MinimumQuake();
    System.out.println("Strongest Quake: " + minQua.toString());

    Quake maxQua = qF.MaximumQuake();
    System.out.println("Weakest Quake: " + maxQua.toString());

    Quake minDep = qF.DepthlessQuake();
    System.out.println("Minimum Depth: " + minDep.toString());

		Quake maxDep = qF.DeepestQuake();
    System.out.println("Maximum Depth: " + maxDep.toString());

  }

  private static boolean isLevelValid(String level) // Making sure user doesnt enter something not recognised by program
  {
    if (level.equals("significant"))
    {
      return true;
    }
    else if (level.equals("4.5"))
    {
      return true;
    }
    else if (level.equals("2.5"))
    {
      return true;
    }
    else if (level.equals("1.0"))
    {
      return true;
    }
    else if (level.equals("all"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  private static boolean isPeriodValid(String period) // Making sure user doesnt enter something not recognised by program
  {
    if (period.equals("hour"))
    {
      return true;
    }
    else if (period.equals("day"))
    {
      return true;
    }
    else if (period.equals("week"))
    {
      return true;
    }
    else if (period.equals("month"))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
