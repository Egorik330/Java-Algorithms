[1.3] Контейнеры, очереди, стеки:

Tasks\1.3\4 (Plan: 0.33 | Fact: 0.5)

Tasks\1.3\29 (Plan: 0.5 | Fact: 0.5)

Tasks\1.3\37 (Plan: 0.75 | Fact: 0.75)

Tasks\1.3\32 (Plan: 0.5 | Fact: 0.75)

1.3.4:
***
Напишите клиент стека Parentheses, который читает поток символов из стандартного ввода 
и использует стек для определения правильности балансировки скобок. Например, программа
должна вывести true для [()]{}{()()} и false для [(]).

1.3.29:
***
Напишите реализацию класса Queue, в которой используется кольцевой связный список - такой же,
как и обычный связный список, но без нулевых ссылок т.е. last.next содержит значение first,
если список не пуст. Используйте только одну переменную экземпляров Node(last).

1.3.37:
***
Задача Иосифа. Эта задача известна из глубокой древности. N человекам нуж- но было выбрать одного,
и для этого они встали в круг (позиции с номерами от 0 до -1) и считали по кругу, удаляя каждого М-го человека,
пока не остался один. Легенда гласит, что Иосиф Флавий вычислил то место, которое остается последним.
Напишите клиент Josephus для класса Queue, который принимает из командной строки числа М и М и выводит порядок,
в котором выбывают люди (и таким образом подсказывает Иосифу, какое место в круге следует выбрать). 

% java Josephus 7 2
1350426

1.3.32:
***
Стеко-очередь. Очередь с элементами поведения стека, или стеко-очередь - это тип данных, поддерживающий операции 
втолкнуть, вытолкнуть и занести. Сформулируйте API-интерфейс для такого АТД. Разработайте реализацию на
основе связного списка.
