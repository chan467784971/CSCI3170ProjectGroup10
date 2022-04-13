package model.file;

import java.sql.Connection;

public interface fileModelInterface{
    public void saveToDB(Connection connect);
    public void parseFromLine(String line);
}