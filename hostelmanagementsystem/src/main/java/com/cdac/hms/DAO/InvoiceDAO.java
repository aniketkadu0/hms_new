package com.cdac.hms.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.hms.model.Invoice;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, Integer>{

}
