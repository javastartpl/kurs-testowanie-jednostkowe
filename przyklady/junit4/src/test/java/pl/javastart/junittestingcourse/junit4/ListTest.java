package pl.javastart.junittestingcourse.junit4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    private List<String> list = new ArrayList<String>();

    @Test
    public void asd() {
        list.add("");
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void asd2() {
        list.add("a");
        list.add("b");
        Assert.assertEquals(list.size(), 2);
    }

}
