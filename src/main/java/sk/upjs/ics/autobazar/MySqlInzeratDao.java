package sk.upjs.ics.autobazar;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.LinkedList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

public class MySqlInzeratDao implements InzeratDao{
    private JdbcTemplate jdbcTemplate;
    
    public MySqlInzeratDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/autobazar");
        dataSource.setUser("autobazar");
        dataSource.setPassword("autobazar");
        
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void pridat(Inzerat inzerat) {
        String sql = "INSERT INTO inzerat VALUES (?,?,?)";
        jdbcTemplate.update(sql,null,inzerat.getZnacka(),inzerat.getModel());
    }

    @Override
    public List<Inzerat> dajVsetky() {
        String sql = "SELECT * FROM inzerat";
        BeanPropertyRowMapper<Inzerat> mapper = BeanPropertyRowMapper.newInstance(Inzerat.class);
        return jdbcTemplate.query(sql, mapper); /*dam dopyt a mapper a vypuje zoznam uloh ktore mozme pouzit*/
    }

    @Override
    public void odstranit(Inzerat uloha) {
        String sql = "delete from inzerat where id = ?";
        jdbcTemplate.update(sql, uloha.getId());
    }

    @Override
    public List<Inzerat> vyhladaj(String znacka, String model, String odRocnik, String doRocnik) {
        //String sql = "select * from inzerat where znacka = ? and model = ? and rocnik >= ? and rocnik <= ?";
        //BeanPropertyRowMapper<Inzerat> mapper = BeanPropertyRowMapper.newInstance(Inzerat.class);
        String sql = "SELECT * FROM inzerat";
        BeanPropertyRowMapper<Inzerat> mapper = BeanPropertyRowMapper.newInstance(Inzerat.class);
        List<Inzerat> pomocna = jdbcTemplate.query(sql, mapper);
        List<Inzerat> pomocna2 = new LinkedList<Inzerat>();
        for (Inzerat a1 : pomocna) {
            if (a1.getZnacka().equals(znacka)) {
                if (a1.getModel().equals(model)) {
                    int a = a1.getRocnik().compareTo(odRocnik);
                    int b = a1.getRocnik().compareTo(doRocnik);
                    if (a >= 0 && b <= 0) {
                        System.out.println(" ");
                        pomocna2.add(a1);
                    }
                }
            }
        }
        return pomocna2;
    }
}
