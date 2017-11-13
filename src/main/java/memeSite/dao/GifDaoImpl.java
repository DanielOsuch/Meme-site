package memeSite.dao;

import model.Gif;

import java.util.ArrayList;
import java.util.List;

public class GifDaoImpl implements GifDao {
    private static List<String> names = new ArrayList<>();

    static {
        names.add("android-explosion");
        names.add("");
    }


    public List<Gif> findAll() {
        List<Gif> gifs = new ArrayList<>();
        int i =1;
        for(String name:names){
            gifs.add(new Gif(name, "username"+i++));
        }
        return gifs;
    }
}