package willr27.blocklings.whitelist;

import java.util.TreeMap;

public abstract class Whitelist<T> extends TreeMap<T, Boolean>
{
    public boolean isWhitelisted(T entry)
    {
        return get(entry);
    }

    public boolean isBlacklisted(T entry)
    {
        return !isWhitelisted(entry);
    }

    public void setEntry(T entry, boolean value)
    {
        replace(entry, value);
    }

    public void toggleEntry(T entry)
    {
        setEntry(entry, !get(entry));
    }

    public void setAll(boolean value)
    {
        for (T entry : keySet())
        {
            setEntry(entry, value);
        }
    }

    public void toggleAll()
    {
        for (T entry : keySet())
        {
            toggleEntry(entry);
        }
    }
}
