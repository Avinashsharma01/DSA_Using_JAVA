@echo off
REM DSA Java Revision Helper Script
REM Quick access to compile and run Java files

:menu
cls
echo ===============================================
echo    DSA JAVA REVISION HELPER
echo ===============================================
echo.
echo Select Topic to Revise:
echo.
echo 1.  Arrays
echo 2.  Searching Algorithms
echo 3.  Sorting Algorithms
echo 4.  Recursion
echo 5.  Linked Lists
echo 6.  Stacks
echo 7.  Queues
echo 8.  Strings
echo 9.  OOP Concepts
echo 10. Exception Handling
echo 11. Logic Building
echo 12. Open Revision Guide
echo 13. Open Quick Reference
echo 14. Open Progress Tracker
echo 0.  Exit
echo.
set /p choice="Enter your choice (0-14): "

if "%choice%"=="1" goto arrays
if "%choice%"=="2" goto searching
if "%choice%"=="3" goto sorting
if "%choice%"=="4" goto recursion
if "%choice%"=="5" goto linkedlist
if "%choice%"=="6" goto stack
if "%choice%"=="7" goto queue
if "%choice%"=="8" goto strings
if "%choice%"=="9" goto oop
if "%choice%"=="10" goto exceptions
if "%choice%"=="11" goto logic
if "%choice%"=="12" goto guide
if "%choice%"=="13" goto reference
if "%choice%"=="14" goto tracker
if "%choice%"=="0" goto end
goto menu

:arrays
cls
echo ===============================================
echo    ARRAYS REVISION
echo ===============================================
echo.
cd src\Arrays
echo Files in Arrays folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:searching
cls
echo ===============================================
echo    SEARCHING ALGORITHMS REVISION
echo ===============================================
echo.
cd src\SearchingAlgo
echo Files in SearchingAlgo folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:sorting
cls
echo ===============================================
echo    SORTING ALGORITHMS REVISION
echo ===============================================
echo.
cd src\Sorting
echo Files in Sorting folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:recursion
cls
echo ===============================================
echo    RECURSION REVISION
echo ===============================================
echo.
cd src\Recursion
echo Files in Recursion folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:linkedlist
cls
echo ===============================================
echo    LINKED LISTS REVISION
echo ===============================================
echo.
cd src\Linkedlist
echo Files in Linkedlist folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:stack
cls
echo ===============================================
echo    STACKS REVISION
echo ===============================================
echo.
cd src\Stack
echo Files in Stack folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:queue
cls
echo ===============================================
echo    QUEUES REVISION
echo ===============================================
echo.
cd src\Queue
echo Files in Queue folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:strings
cls
echo ===============================================
echo    STRINGS REVISION
echo ===============================================
echo.
cd src\PlayWithStrings
echo Files in PlayWithStrings folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:oop
cls
echo ===============================================
echo    OOP CONCEPTS REVISION
echo ===============================================
echo.
cd src\Opps
echo Folders in Opps:
dir /b
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:exceptions
cls
echo ===============================================
echo    EXCEPTION HANDLING REVISION
echo ===============================================
echo.
cd src\ExaptionHandling
echo Files in ExaptionHandling folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:logic
cls
echo ===============================================
echo    LOGIC BUILDING REVISION
echo ===============================================
echo.
cd src\Logic
echo Files in Logic folder:
dir /b *.java
echo.
echo Opening folder...
start .
echo.
pause
goto menu

:guide
cls
echo Opening Revision Guide...
start REVISION_GUIDE.md
pause
goto menu

:reference
cls
echo Opening Quick Reference...
start QUICK_REFERENCE.md
pause
goto menu

:tracker
cls
echo Opening Progress Tracker...
start PROGRESS_TRACKER.txt
pause
goto menu

:end
cls
echo.
echo Thank you for using DSA Java Revision Helper!
echo Keep practicing! Good luck! 🚀
echo.
timeout /t 2 >nul
exit

