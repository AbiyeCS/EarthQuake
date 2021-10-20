import java.net.*;
import java.io.*;
import java.util.*;
/**
 * An earthquake dataset obtained from the USGS web feed.
 */
public class QuakeFeed
{
    public String level;
    public String period;
    public ArrayList<Quake> list = new ArrayList<Quake>();

    private static final String WEB_TEMPLATE =
   "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/%s_%s.csv";

   public QuakeFeed(String level, String period)
    {
      this.level = level;
      this.period = period;
    }

    public int size()
    {
      return list.size();
    }

    public Quake get(int i)
    {
        return list.get(i);
    }


    public Quake MinimumQuake() //Finds the weakest quake in list
    {
        double weakestQuake = 0;
        int x = 0;
        for(int i=0; i<list.size();i++)
        {
          if(list.get(i).getMagnitude()<weakestQuake)
          {
            weakestQuake = list.get(i).getMagnitude();
            x = i;
          }
        }

        return list.get(x);
    }

    public Quake MaximumQuake() //Finds strongest quake in list
    {
      Quake strongestQuake = get(0);
      for(Quake quake : list)
      {
         if(quake.getMagnitude() > strongestQuake.getMagnitude())
            strongestQuake = quake;
      }
      return strongestQuake;
    }

    public Quake DepthlessQuake() //Finds the quake with the smallest depth
    {
        double smallestDepth= 0;
        int y = 0;

        for(int i=0; i<list.size();i++)
        {

          if(list.get(i).getDepth()<smallestDepth)
          {
            smallestDepth = list.get(i).getDepth();
            y = i;
          }
        }

        return list.get(y);
      }

      public void quakeOuput()//Done
      {
        for(int i=0; (i<=list.size()); i++)
        {
          list.get(i).toString();
        }
      }

    public Quake DeepestQuake() //Finds the deepest quake in list
    {
      Quake biggestDepth = get(0);
          for(Quake quake : list)
          {
             if(quake.getDepth() > biggestDepth.getDepth())
                biggestDepth = quake;
          }
          return biggestDepth;
    }


    public void add(Quake i)
    {
      list.add(i);
    }


    public int update()
    {
      try
      {
        String Link = String.format(WEB_TEMPLATE, level, period);
        URL connected = new URL(Link);
        InputStream inputStream = connected.openStream();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        buffReader.readLine();

        for (int z=0; (inputLine = buffReader.readLine()) != null; z++)
        {
          Quake qua = new Quake(inputLine);
          add(qua);
          System.out.println(list);
        }

        buffReader.close();
      }
      catch(IOException e)
      {
        System.out.println("Sorry, something went wrong. Please check connection and try again");
      }
      return 0;
    }
 }
