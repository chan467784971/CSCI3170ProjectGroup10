package model.file;

import java.sql.Connection;

public interface fileModelInterface{
    public void parseFromLine(String line);
    public void saveToDB(Connection connect);
}