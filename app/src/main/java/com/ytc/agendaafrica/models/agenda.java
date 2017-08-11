package com.ytc.agendaafrica.models;

/**
 * Created by kzone on 6/17/2017.
 */

public class agenda {
    int id;
    String agendatitle;
    String agendadetail;

    public agenda() {
    }

    public agenda(int id, String agendatitle, String agendadetail) {
        this.id = id;
        this.agendatitle = agendatitle;
        this.agendadetail = agendadetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgendatitle() {
        return agendatitle;
    }

    public void setAgendatitle(String agendatitle) {
        this.agendatitle = agendatitle;
    }

    public String getAgendadetail() {
        return agendadetail;
    }

    public void setAgendadetail(String agendadetail) {
        this.agendadetail = agendadetail;
    }
}
