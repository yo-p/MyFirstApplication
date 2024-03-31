package com.example.myfirstapplication.app.survey;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class SurveyForm {
    @NotNull
    @Min(0)
    @Max(150)
    private int age;
    @NotNull
    @Min(1)
    @Max(5)
    private int satisfaction;
    @NotNull
    @Size(min = 1, max = 200, message = "1 ~ 200文字以内で入力してください。")
    private String comment;
}
