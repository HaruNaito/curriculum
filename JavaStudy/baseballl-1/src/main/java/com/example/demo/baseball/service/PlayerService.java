package com.example.demo.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.baseball.domain.Player;
import com.example.demo.baseball.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    //JDBC Templateを定義する。
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    //コンストラクタを定義する。
    public PlayerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    //IDを引数にして1件のレコードを取得する処理
    public Player findById(Long id) {
        return playerRepository.findById(id).get();
    }


    //追加　20210902
    public Player insertSave(Player player) {

        //関数findMaxIdメソッドからIDの最大値を取得して変数maxIdに入れる。
        long maxId = findMaxId();
        //maxIdに1を加算して新規IDを取得する。
        maxId = maxId + 1;
        //クエリ文を実行する。
        jdbcTemplate.update("INSERT INTO PLAYER (id,age,name,position,team) VALUES(?,?,?,?,?) ",
                maxId,player.getAge(),player.getName(),player.getPosition(),player.getTeam());

        return player;
    }

    /*
     * IDの最大値を取得する処理
     * @return IDの最大値
     */
    public long findMaxId() {

        //クエリ文を用意する。
        String queryString = "SELECT MAX(id) FROM PLAYER";

        //jdbcTemplate.queryForObjectメソッドから返却された値を入れる変数selectedMaxIdを用意する。
        Object selectedMaxId ="";

        //IDの最大値を入れる変数maxIdを用意して0を入れて初期化する。
        long maxId =0;

        /*
         * jdbcTemplate.queryForObjectにクエリ文を入れて実行する。
         * @selectedMaxId データベースにレコードが存在する場合、IDの最大値が変数selectedMaxIdに格納される。
         * @selectedMaxId データベースにレコードが存在しない場合、NULLが変数selectedMaxIdに格納される。
         * */
        selectedMaxId = jdbcTemplate.queryForObject(queryString, long.class);

        //変数selectedMaxIdに格納されている値がNULLの場合、変数maxIdを返却(return)する。
        if (selectedMaxId == null) {
            return maxId;
        }

        //queryForObjectメソッドでIDの最大値を取得・返却する。
        return jdbcTemplate.queryForObject(queryString, long.class);
    }

    /*
     * 該当レコードを削除する処理
     * @param id
     * */
    public void delete(Long id){
        playerRepository.deleteById(id);
    }

	public void save(Player player) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}