package mmo.app.spring5recipeapp.domain

import org.hibernate.validator.constraints.NotBlank
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @NotBlank
    var description: String = ""

    @Min(1)
    @Max(999)
    var prepTime: Int = 0

    @Min(1)
    @Max(999)
    var cookTime: Int = 0

    var servings: Int = 0

    var source: String = ""

    var url: String = ""

    @Lob
    var directions: String = ""

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "recipe")
    var ingredients: Set<Ingredient> = hashSetOf()

    var image: Byte = Byte.MIN_VALUE

    @Enumerated(value = EnumType.STRING)
    var difficulty: Difficulty = Difficulty.EASY

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var notes: Notes = Notes()

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = arrayOf(JoinColumn(name = "recipe_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
    var categories: Set<Category> = HashSet()



}