import java.net.*;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
/**
 * Details of a single earthquake.
 */
public class Quake
{
  double latitude;
  double longitude;
  double depth;
  double magnitude;

  public String toString()
  {
    DecimalFormat tens = new DecimalFormat("#.0");
    DecimalFormat tenThousands = new DecimalFormat("#.0000");
    String magnitudeOutput= "M" + tens.format(magnitude);
    String depthOutput= ", " + tens.format(depth);
    String latitudeOutput= ", (" + tenThousands.format(latitude);
    String longitudeOutput= "\u00b0, " + tenThousands.format(longitude) + " \u00b0";
    String finalOutput = magnitudeOutput+ ", " + depthOutput+ ", " + latitudeOutput+ ", " + longitudeOutput;

    return finalOutput;
  }

  public Quake(String record)
  {
    String[] splitting = record.split(",");
		try
    {
      latitude = Double.parseDouble(splitting[1]);
      longitude = Double.parseDouble(splitting[2]);
      depth = Double.parseDouble(splitting[3]);
      magnitude = Double.parseDouble(splitting[4]);
		}
    catch (NumberFormatException e)
    {
      System.out.println("Please re-try later");
		}

	 }

  public void setLatitude(double latitude)
  {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude)
  {
    this.longitude = longitude;
  }

  public void setDepth(double depth)
  {
    this.depth = depth;
  }

  public void setMagnitude(double magnitude)
  {
    this.magnitude = magnitude;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public double getLongitude()
  {
    return longitude;
  }

  public double getDepth()
  {
    return depth;
  }

  public double getMagnitude()
  {
    return magnitude;
  }


}
