package com.example.hiennv.mvparchitecture.data.db;

import com.example.hiennv.mvparchitecture.data.db.model.Option;
import com.example.hiennv.mvparchitecture.data.db.model.Question;
import com.example.hiennv.mvparchitecture.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {
    //Insert user
    Observable<Long> insertUser(User user);
    //Get list user
    Observable<List<User>> getAllUser();

    Observable<List<Question>> getAllQuestion();

    //Kiem tra bang question co trong hay k
    Observable<Boolean> isQuestionEmpty();

    //Kiem tra bang Option co trong
    Observable<Boolean> isOptionEmpty();

    //Luu 1 question
    Observable<Boolean> saveQuestion(Question question);

    //Luu 1 option
    Observable<Boolean> saveOption(Option option);

    //Luu danh sach question
    Observable<Boolean> saveQuestionList(List<Question> questions);

    //Luu 1 danh sach option
    Observable<Boolean> saveOptionList(List<Option> options);
}
