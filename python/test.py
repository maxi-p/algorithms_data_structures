class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
        self.say_hi()
    
    def __str__(self):
        return f"Person ({self.name}, {self.age})"

    def say_hi(self):
        print(f'Hi, Im {self.name}!')


maks = Person("Maksim", 23)
gena = Person("Gena", 23)
