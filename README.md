# Simple Calculator App Documentation

Welcome to the comprehensive documentation for the Simple Calculator App. In this guide, you will find detailed explanations of the app's features, code structure, and usage.
![image](https://github.com/suraiya-jahan-bhuiyan-sraboni/Simple-Calculator-App/assets/85396098/669d98f6-8b53-435c-a9bd-1e3d1e6b8fb8)
![image](https://github.com/suraiya-jahan-bhuiyan-sraboni/Simple-Calculator-App/assets/85396098/f4f41c05-dda2-41a8-88a2-df39ac013f33)



## Table of Contents
1. **Introduction**
2. **Features**
3. **Getting Started**
   - Prerequisites
   - Installation
4. **App Structure**
   - XML Layout (`activity_main.xml`)
   - MainActivity Kotlin Code (`MainActivity.kt`)
   - Resources (`strings.xml` and `styles.xml`)
5. **Dependencies**
6. **Usage**
7. **EvaluateExpression Function**
8. **Conclusion**

## 1. Introduction
The Simple Calculator App is a beginner-level Android application built using Kotlin and the Android Jetpack components. It offers users a user-friendly interface to perform basic arithmetic calculations and understand the fundamentals of Android app development.

## 2. Features
- Arithmetic Operations: Addition, subtraction, multiplication, and division.
- Decimal Support: Input and calculation of decimal numbers.
- Clear Functionality: Clear input and start over (AC).
- Delete Input: Remove the last character entered (DEL).
- Parentheses Handling: Incorporate parentheses in calculations.
- Display Expression and Result: Visual representation of the input expression and calculated result.
- Expression Evaluation: Exp4j library to evaluate mathematical expressions.

## 3. Getting Started

### Prerequisites
- Android Studio: Ensure you have Android Studio installed and configured.

### Installation
1. Clone the Project: Clone or download the project from the repository.
2. Open in Android Studio: Launch Android Studio and open the project directory.
3. Build and Run: Build and run the app on an emulator or physical device.

## 4. App Structure

### XML Layout (`activity_main.xml`)
The app's user interface is described using XML in the `activity_main.xml` layout file. This file incorporates a ConstraintLayout that organizes the buttons and TextViews.

### MainActivity Kotlin Code (`MainActivity.kt`)
The `MainActivity.kt` file contains the Kotlin code responsible for powering the app's functionality. This code interacts with the UI elements defined in the XML layout.

Let's explore the code in detail:
```kotlin
// Import necessary libraries and modules
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
```

```kotlin
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var input: String = ""
    private var bracketsCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize UI elements and setup
        // ...

        // Set up button click listeners
        binding.zero.setOnClickListener { /* Logic for button zero */ }
        binding.one.setOnClickListener { /* Logic for button one */ }
        // ... (Repeat for other buttons)
        
        // Handle equal button click
        binding.equal.setOnClickListener {
            // Evaluate the expression and display the result
            if (input.isNotEmpty()) {
                try {
                    val result = evaluateExpression(input)
                    binding.answerView.text = "= $result"
                } catch (e: Exception) {
                    binding.answerView.text = "= Error"
                }
            }
        }
    }
    
    // Function to evaluate mathematical expression using Exp4j library
    private fun evaluateExpression(expression: String): String {
        return try {
            val exp = ExpressionBuilder(expression).build()
            val result = exp.evaluate()
            result.toString()
        } catch (e: Exception) {
            throw e
        }
    }
}
```

### Resources (`strings.xml` and `styles.xml`)
The `strings.xml` file contains string resources used throughout the app, such as button labels and default values. The `styles.xml` file defines the app's theme and appearance.

## 5. Dependencies
The app utilizes various libraries and dependencies to achieve its functionality. These dependencies include:
- Kotlin Standard Library: Core Kotlin functionality.
- Exp4j: A library for evaluating mathematical expressions.
- AndroidX Libraries: Core Android components and UI elements.
- Material Design Components: UI components following Material Design guidelines.

## 6. Usage
1. Launch the app on your Android device.
2. Use the number buttons (0-9) to input numbers.
3. Use the operator buttons (+, -, *, /) to perform operations.
4. Press the DOT button to add decimal points.
5. Use the BRACKETS button to include parentheses in expressions.
6. Press the AC button to clear the input expression.
7. Press the DEL button to remove the last character.
8. Press the EQUAL button to calculate the result.
9. The input expression and result are displayed on the screen.

## 7. EvaluateExpression Function
The `evaluateExpression` function plays a crucial role in the app's functionality. Let's delve into how it works:

```kotlin
private fun evaluateExpression(expression: String): String {
    return try {
        val exp = ExpressionBuilder(expression).build()
        val result = exp.evaluate()
        result.toString()
    } catch (e: Exception) {
        throw e
    }
}
```

This function takes an input expression as a parameter, uses the ExpressionBuilder from the Exp4j library to create an expression object, and then evaluates the expression using the `evaluate` method. The result is converted to a string and returned. If any exceptions occur during the evaluation, they are propagated as-is.

## 8. Conclusion
Congratulations! You've now explored the detailed documentation of the Simple Calculator App. This app is an excellent starting point for those interested in learning about Android app development using Kotlin. Feel free to modify and enhance the app to suit your needs, and use it as a foundation for more advanced projects. Happy coding!
