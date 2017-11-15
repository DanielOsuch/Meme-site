package memeSite.dao;



import memeSite.model.Gif;

import java.util.*;
import java.util.stream.Collectors;

public class GifDaoImpl implements GifDao {
    private static List<Gif> names = new ArrayList<>();

    static {
        names.add(new Gif("android-explosion",false,1));
        names.add(new Gif("ben-and-mike",true,3));
        names.add(new Gif("book-dominos",false,2));
        names.add(new Gif("compiler-bot",true,1));
        names.add(new Gif("cowboy-coder",false,2));
        names.add(new Gif("infinite-andrew",true,3));
    }

    public List<Gif> findAll() {
        List<Gif> gifs = new ArrayList<>();
        int i =1;
        for(Gif name:names){
            gifs.add(new Gif(name.getName(),name.getId(),"username"+i++));
        }
        return gifs;
    }


    @Override
    public List<Gif> findFavorites() {
        List<Gif> gifs = new ArrayList<>();
        Random rand = new Random();
        int i =0;
        for (Gif name:names) {

            if(name.isFavorites()){
                gifs.add(new Gif(name.getName(), "username"+i++));
            }
        }
        return gifs;
    }

    @Override
    public Gif findByCategoryId(int id) {
        return findAll().stream().filter((g)-> g.getId()==id).collect(Collectors.toList()).get(0);
    }

    public Gif findOne(String name){
        return findAll().stream().filter(a->a.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public List<Gif> findGifById(int id){
        List<Gif> gifsById = new ArrayList<>();
        for (Gif idName : names){
            if(idName.getId()==id){
            gifsById.add(new Gif(idName.getName(),idName.getId()));}
        }
        return gifsById;
    }
    public List<Gif> findGifByName(String name){
        List<Gif> gifsByName = new ArrayList<>();
        for (Gif gifName : names){
            if(gifName.getName().equals(name)){
                gifsByName.add(new Gif(gifName.getName()));}
        }
        return gifsByName;
    }



}
