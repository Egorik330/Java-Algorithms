[3.3] Сбалансированные деревья бинарного поиска:

Tasks\3.3.39 (Plan: 1.5 | Fact: 2)

Tasks\3.3.40 (Plan: 1.0 | Fact: 0.7)

Tasks\3.3.42 (Plan: 0.5 | Fact: 0.5)

Tasks\3.3.30 (Plan: 0.5 | Fact: 0.3)

3.3.39
***
Удаление наименьшего. Реализуйте операцию deleteMin() для красно-черных ДБП, используя преобразования, описанные в тексте, для спуска по левому пути дерева и поддерживая инвариант, что текущий узел не является 2-узлом.

3.3.40 
***
Удаление наибольшего. Реализуйте операцию deleteMax() для красно-черных ДБП. Учтите, что необходимые для этого преобразования несколько отличаются от преобразований для deleteMin(), т.к. красные ссылки направлены влево.

3.3.42
***
Подсчет красных узлов. Напишите программу, которая вычисляет процент красных узлов в заданном красно-черном ДБП. Проверьте работу программы, выполнив, по крайней мере, 100 раз вставку N случайных ключей в первоначально пустое дерево, для N = 10^4, 10^5 и 10^6.

3.2.30
***
Программное кеширование. Добавьте в класс RedBlackBST хранение последнего узла, к которому было обращение, в переменной экземпляров, чтобы иметь доступ к этому узлу за постоянное время, если следующая операция put() или get() использует тот же ключ.