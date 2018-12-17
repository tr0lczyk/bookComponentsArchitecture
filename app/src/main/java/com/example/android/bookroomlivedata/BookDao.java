package com.example.android.bookroomlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insertBook(Book book);

    @Update
    void updateBook(Book book);

    @Query("SELECT * FROM book_table WHERE id =:id")
    LiveData<Book> getBookWithId(int id);

    @Query("DELETE FROM book_table")
    void deleteAllBooks();

    @Query("SELECT * FROM book_table ORDER BY id DESC")
    LiveData<List<Book>> getAllBooks();

    @Delete
    void deleteBook(Book book);

}
