package edu.iu.ndshetty.historyservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table
public class PrimesRecord {
    @Id
    @GeneratedValue
    private int id;
    private String customer;
    private String n;
    private boolean isPrime;

    public int getId() { return id; }
}
