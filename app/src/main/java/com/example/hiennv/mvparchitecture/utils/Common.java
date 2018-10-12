package com.example.hiennv.mvparchitecture.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.hiennv.mvparchitecture.R;
import com.example.hiennv.mvparchitecture.data.db.model.Option;
import com.example.hiennv.mvparchitecture.data.db.model.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    //Hide keyboard
    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    //Show loading
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    /**
     * @param context
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String loadJsonFromAsset(Context context, String fileName) throws IOException {
        AssetManager am = context.getAssets();
        InputStream is = am.open(fileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }

    /**
     * @param context
     * @return
     */
    public static List<Question> parseListQuestion(Context context) {
        List<Question> questionList = new ArrayList<>();
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String json = loadJsonFromAsset(context, AppConstants.SEED_DATABASE_QUESTIONS);
            JSONArray arrQuestion = new JSONArray(json);
            for (int i = 0; i < arrQuestion.length(); i++) {
                Question question = gson.fromJson(arrQuestion.getString(i), Question.class);
                questionList.add(question);
            }
            return questionList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param context
     * @return
     */
    public static List<Option> parseListOption(Context context) {
        List<Option> optionList = new ArrayList<>();
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String json = loadJsonFromAsset(context, AppConstants.SEED_DATABASE_OPTIONS);
            JSONArray arrOption = new JSONArray(json);
            for (int i = 0; i < arrOption.length(); i++) {
                Option option = gson.fromJson(arrOption.getString(i), Option.class);
                optionList.add(option);
            }
            return optionList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param context
     * @return id device
     */
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    //Check validate email
    public static boolean isValidEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).format(new Date());
    }
}
