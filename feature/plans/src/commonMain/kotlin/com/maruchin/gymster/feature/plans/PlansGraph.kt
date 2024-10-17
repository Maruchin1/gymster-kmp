package com.maruchin.gymster.feature.plans

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.gymster.feature.plans.plandetails.PlanDetailsScreen
import com.maruchin.gymster.feature.plans.plandetails.navigateToPlanDetails
import com.maruchin.gymster.feature.plans.plandetails.planDetailsScreen
import com.maruchin.gymster.feature.plans.planlist.PlanListScreen
import com.maruchin.gymster.feature.plans.planlist.planListScreen
import kotlinx.serialization.Serializable

@Serializable
internal data object PlansGraph

fun NavController.navigateToPlans() {
    navigate(PlansGraph)
}

fun NavController.navigateToPlans(planId: String) {
    navigate(PlanDetailsScreen(planId))
}

fun NavGraphBuilder.plansGraph(navController: NavController) {
    navigation<PlansGraph>(startDestination = PlanListScreen) {
        planListScreen(
            onBack = { navController.navigateUp() },
            onOpenPlan = { navController.navigateToPlanDetails(it) }
        )
        planDetailsScreen(
            onBack = { navController.navigateUp() }
        )
    }
}
