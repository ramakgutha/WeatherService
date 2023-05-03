package com.weather.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utils
{
    List<String> list (String ... strs)
    {
        return Collections.unmodifiableList(Arrays.asList(strs));
    }

    Integer toInteger (String str)
    {
        return new Integer (str);
    }
}
