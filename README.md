# Очередное тестовое задание:
Необходимо реализовать простейшее приложение, которое будет отображать список случайной длины от 10 до 100 элементов. При тапе по элементу, открывать новый экран с отображением подробной информации об элементе.
Список формируется случайным способом из объектов трех типов:
```php
data class Notice {
	var flightDate: Date? = null
	var gate: String? = null
}
class Event {
	var startTime: Date? = null
	var endTime: Date? = null
	var name: String! = null
}
class Move {
	var fromPlace: String? = null
	var toPlace: String? = null
	var estimateTime: TimeInterval? = null
}
```
Ячейка списка содержит текстовое описание объекта в виде "название" - "детали". На экране деталей - подробная информация в виде полей в зависимости от типа элемента.
