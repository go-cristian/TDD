package co.iyubinest.tdd;

import java.io.Serializable;

/**
 * Created by cristiangomez on 3/12/15.
 */
public class Pokemon implements Serializable
{

    private final String name;

    private final String url;

    public Pokemon(String name, String url)
    {

        this.name = name;
        this.url = url;
    }

    public String getName()
    {

        return name;
    }

    public String getUrl()
    {

        return url;
    }
}
