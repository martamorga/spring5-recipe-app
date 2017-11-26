package mmo.app.spring5recipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var description: String = ""

    var amount: BigDecimal = BigDecimal(0)

    @ManyToOne
    var recipe: Recipe = Recipe()
}