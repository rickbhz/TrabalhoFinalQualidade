

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitationProvider {
    List<String> autor = new ArrayList();
    List<String> citacao = new ArrayList();
    String lastRes = "";

    public CitationProvider() {
        this.autor.add("Frank Clark");
        this.autor.add("Caio Fernando Abreu");
        this.autor.add("Leonardo Da Vinci");
        this.autor.add("Erich Fromm");
        this.autor.add("Albert Einstein");
        this.autor.add("Walt Disney");
        this.autor.add("Taniguchi");

        this.citacao.add("Se voce encontrar um caminho sem obstaculos, ele provavelmente nao leva a lugar nenhum.");
        this.citacao.add("Da vontade de amar. De amar de um jeito ‘certo’, que a gente nao tem a menor ideia de qual poderia ser, se e que existe um.");
        this.citacao.add("O tempo dura bastante para aqueles que sabem aproveita-lo.");
        this.citacao.add("O amor e um ato de fe. Quem tiver pouca fe tambem tera pouco amor.");
        this.citacao.add("Algo so e impossivel ate que alguem duvide e resolva provar ao contrario.");
        this.citacao.add("Decidi nao esperar as oportunidades e sim, busca-las. Decidi ver cada dia como uma nova oportunidade de ser feliz");
        this.citacao.add("A felicidade repartida com o proximo dura para sempre.");
    }



    public void AddCitation(String addAuthor, String addCitation) {
        this.autor.add(addAuthor);
        this.citacao.add(addCitation);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }


    public String GetCitation() {
        Integer number = Integer.valueOf(randInt(0, this.autor.size() - 1));

        String autorRes = (String)this.autor.get(number.intValue());

        String res;

        if(autorRes.length() <= 30) {
            res = autorRes;
        } else {
            res = autorRes.substring(0, 28) + "..";
        }



        String citacaoRes = (String)this.citacao.get(number.intValue());
        if(citacaoRes.length() <= 200) {
            res = "'" + citacaoRes + "'" + " (" + res + ")";
        } else {
            res = "'" + citacaoRes.substring(0, 198) + "' .. (" + res + ")";
        }

        while(this.lastRes.equals(res)) {
            number = Integer.valueOf(randInt(0, this.autor.size() - 1));
            autorRes = (String)this.autor.get(number.intValue());
            if(autorRes.length() <= 30) {
                res = autorRes;
            } else {
                res = autorRes.substring(0, 28) + "..";
            }

            citacaoRes = (String)this.citacao.get(number.intValue());
            if(citacaoRes.length() <= 200) {
                res = "'" + citacaoRes + "'" + " (" + res + ")";
            } else {
                res = "'" + citacaoRes.substring(0, 198) + "' .. (" + res + ")";
            }
        }

        return res;
    }
}
