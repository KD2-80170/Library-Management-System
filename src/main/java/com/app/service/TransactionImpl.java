package com.app.service;



import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookRepository;
import com.app.dao.TransactionRepository;
import com.app.dao.UserRepository;
import com.app.dto.TransactionDTO;
import com.app.dto.TransactionRespo;
import com.app.entities.Book;
import com.app.entities.Transaction;
import com.app.entities.User;

@Service
@Transactional
public class TransactionImpl implements TransactionService {
	@Autowired
	private TransactionRepository tansrepo;
	@Autowired
	private BookRepository bookrepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	UserRepository userrepo;
	
	@Override
	public TransactionRespo addTransaction(TransactionDTO dto) {
		// TODO Auto-generated method stub
          Book book =bookrepo.findById(dto.getBookId())
		 .orElseThrow(()->new ResourceNotFoundException("Resource not found"));
         
         User user=userrepo.findById(dto.getUserId())
        		.orElseThrow(()->new ResourceNotFoundException("Resource not found"));
          //convert dto to class
        
          Transaction trans=mapper.map(dto, Transaction.class);
          trans.setBook(book);
          trans.setUser(user);
          trans.setCheckoutDate(dto.getCheckoutDate());
          trans.setReturnDate(dto.getReturnDate());
         
		return mapper.map(tansrepo.save(trans),TransactionRespo.class);
	}

	@Override
	public String deleteTransDetails(Long transId) {
		if(tansrepo.existsById(transId))
		{
			tansrepo.deleteById(transId);
		
			return "transaction  is not coorect";
		}
	
         throw new  ResourceNotFoundException(" transaction id is not correct");
         }

	@Override
	public List<Transaction> getAllTransaction() {
		
		return tansrepo.findAll() ;
	}
		
	

}
