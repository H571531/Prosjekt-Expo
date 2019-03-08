package no.hvl.dat109.expo.utils;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Stand;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RegistrationUtils {


    static public void registerFromCSVFile(InputStream file, StandEAO sEAO){
        BufferedReader bf = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
        bf.lines().forEach( x -> {
            String parts[] = x.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String navn = parts[1];
            sEAO.addStand(new Stand(navn,id));
        });
    }

}
