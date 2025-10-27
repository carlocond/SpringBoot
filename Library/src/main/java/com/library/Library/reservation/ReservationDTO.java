package com.library.Library.reservation;

//Design pattern utilizzato per il trasferimento dati tra sottosistemi di un'applicazione (Data transfer object)
public class ReservationDTO {
    private Long userId;
    private Long bookId;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }
}
