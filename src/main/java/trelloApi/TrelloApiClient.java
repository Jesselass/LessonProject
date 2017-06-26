package trelloApi;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.apache.xpath.SourceTree;
import org.testng.annotations.Test;
import trelloApi.models.Board;
import trelloApi.models.CheckList;
import trelloApi.models.TrelloCard;
import trelloApi.models.TrelloList;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dell-SSD on 14.06.2017.
 */

public class TrelloApiClient {

    OkHttpClient okHttpClient = new OkHttpClient();
    public static final String KEY = "7f254385587407ea67a63cc6238a65d4";
    public static final String TOKEN = "5628ccb62ee16bd88298dc68f04cbf8d31d2cbdc49d971cd7c8a81e7198c5353";
    public static final String BASE_URL = "https://api.trello.com/1/";

    public String boardId = "pYbUadku";
    // public String idBoard = "594172c37011f70063066b75";
    // public String idList = "59453dfb8b7226ede631b2a1";
    Gson gson = new Gson();


    public Board getBoard() throws IOException {
        String url = BASE_URL + "boards/" + boardId + "?key=" + KEY + "&token=" + TOKEN;
        Request request = new Request.Builder().url(url).build();

        String respJson = okHttpClient.newCall(request).execute().body().string();
        return gson.fromJson(respJson, Board.class);

    }
    public String getLabels(String idBoard) throws IOException {
        String url = BASE_URL + "boards/"+idBoard+"/labels"+"?key="+KEY+"&token="+TOKEN;
        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();

    }

    public String createList(String idBoard, String name) throws IOException {
        String url = BASE_URL + "lists" + "?key=" + KEY + "&token=" + TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("idBoard", idBoard).build();
        Request request = new Request.Builder().post(requestBody).url(url).build();

        return okHttpClient.newCall(request).execute().body().string();
    }

    public String createCard(String name, String idList) throws IOException {
        String url = BASE_URL + "cards" + "?key=" + KEY + "&token=" + TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("idList", idList).build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();

    }

    public List<TrelloList> getBoardLists(String idBoard) throws IOException {
        String url = BASE_URL + "boards/" + idBoard + "/lists" + "?key=" + KEY + "&token=" + TOKEN;
        Request request = new Request.Builder().url(url).build();
        String json = okHttpClient.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloList>>() {}.getType();
        return gson.fromJson(json, type);

    }


    public List<TrelloCard> getAllCards(String idList) throws IOException {
        String url = BASE_URL + "lists/" + idList + "/cards" + "?key=" + KEY + "&token=" + TOKEN;
        Request request = new Request.Builder().url(url).build();

        String json = okHttpClient.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloCard>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public String createCheckList(String idCard) throws IOException {
        String url = BASE_URL + "checklists" + "?key=" + KEY + "&token=" + TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("idCard", idCard).build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }
    public String refreshCardDesc(String idCard,String value) throws IOException {
        String url = BASE_URL +"cards/"+idCard+"/desc"+"?key="+KEY+"&token="+TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("value", value).build();
        Request request = new Request.Builder().put(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }
    public String addComment(String idCard,String text) throws IOException {
        String url = BASE_URL +"cards/"+idCard+"/actions/comments"+"?key="+KEY+"&token="+TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("text",text).build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }
    public String moveCard(String idCard,String value) throws IOException {
        String url = BASE_URL+"cards/"+idCard+"/idList"+"?key="+KEY+"&token="+TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("value",value).build();
        Request request = new Request.Builder().put(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    public String addLabelToCard(String idCard,String color) throws IOException {
        String url = BASE_URL+"cards/"+idCard+"/labels"+"?key="+KEY+"&token="+TOKEN;
        RequestBody requestBody = new FormBody.Builder()
                .add("color",color).build();
        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();

    }






    @Test
    public void azaza() throws IOException {

        Board board = getBoard();
        //System.out.println(getLabels(board.id));
        createList(board.id, "New Test List");
        createList(board.id,"Move To List");

        List<TrelloList> boardLists = getBoardLists(board.id);
        TrelloList tryIt = getBoardLists(board.id).get(1);
        TrelloList moveTo = getBoardLists(board.id).get(0);
        createCard("tryIt",tryIt.id);
        List<TrelloCard> trelloCardsList = getAllCards(tryIt.id);
        TrelloCard tryIt2 = getAllCards(tryIt.id).get(0);
        addLabelToCard(tryIt2.id,"purple");
        createCheckList(tryIt2.id);
        refreshCardDesc(tryIt2.id,"azaza opisanie top");
        addComment(tryIt2.id, "norm koment 4etkiy");
        moveCard(tryIt2.id,moveTo.id);


      /*  for (TrelloList trelloList : boardLists) {

            createCard("azaza", trelloList.id);
            trelloCardsList = getAllCards(trelloList.id);
            for (TrelloCard trelloCard: trelloCardsList){
            if (trelloCard.name.equals("azaza")) {
                createCheckList(trelloCard.id);
            }
        }*/

        }


    }

