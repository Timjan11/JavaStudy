package ru.utegulov.human;

public class HumanWithFather {

        HumanWithName human;
        HumanWithName parent;

        public HumanWithFather(HumanWithName human, HumanWithName parent) {
            this.human = human;
            this.parent = parent;
        }

        void getName(){
            System.out.println();
        }


        public String toString() {
            if (human == null || human.name == null) {
                return "Неизвестный человек";
            }


            Name resultName = new Name(human.name.lastName, human.name.firstName, human.name.surName);


            if (resultName.firstName == null && parent != null && parent.name != null) {
                resultName.firstName = parent.name.firstName;
            }


            if (resultName.surName == null && parent != null && parent.name != null && parent.name.lastName != null) {
                resultName.surName = parent.name.lastName + "ович";
            }

            if (resultName.lastName == null && parent != null && parent.name != null) {
                resultName.lastName = parent.name.lastName;
            }

            return resultName.toString();
        }

}
