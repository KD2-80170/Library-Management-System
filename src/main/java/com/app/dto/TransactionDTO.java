package com.app.dto;

public class TransactionDTO {
	    private Long userId;
	    private Long bookId;
	    private String checkoutDate;
	    private String returnDate;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getBookId() {
			return bookId;
		}
		public void setBookId(Long bookId) {
			this.bookId = bookId;
		}
		public String getCheckoutDate() {
			return checkoutDate;
		}
		public void setCheckoutDate(String checkoutDate) {
			this.checkoutDate = checkoutDate;
		}
		public String getReturnDate() {
			return returnDate;
		}
		public void setReturnDate(String returnDate) {
			this.returnDate = returnDate;
		}
		@Override
		public String toString() {
			return "TransactionDTO [userId=" + userId + ", bookId=" + bookId + ", checkoutDate=" + checkoutDate
					+ ", returnDate=" + returnDate + "]";
		}
		public TransactionDTO(Long userId, Long bookId, String checkoutDate, String returnDate) {
			super();
			this.userId = userId;
			this.bookId = bookId;
			this.checkoutDate = checkoutDate;
			this.returnDate = returnDate;
		}
		public TransactionDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
}
