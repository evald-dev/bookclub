<script setup>
import { useNavigation } from "./useNavigation.js";
import { useAuthStore } from "./stores/auth";
import { ref, watchEffect } from "vue";
const { goToHome, goToLogin, goToOverview, goToProfile, goToAddClub, goToSettings } = useNavigation();
const authStore = useAuthStore();
import AllThemesList from "./components/AllThemesList.vue";
import SideBarItem from "./components/SideBaerItem.vue";
import HomeIcon from "./assets/icons/HomeIocn.vue";
import DashboardIcon from "./assets/icons/DashboardIcon.vue";
import ProfileIcon from "./assets/icons/ProfileIcon.vue";
import LogoutIcon from "./assets/icons/LogoutIcon.vue";
import LoginIcon from "./assets/icons/LoginIcon.vue";
import AddIcon from "./assets/icons/AddIcon.vue";
import SettingIcon from "./assets/icons/SettingIcon.vue";

const currentTheme = ref("retro");

function setTheme(themeName) {
  currentTheme.value = themeName;
}

watchEffect(() => {
  // document.documentElement ist das <html>-Tag
  document.documentElement.setAttribute("data-theme", currentTheme.value);
});
</script>

<template>
  <div>
    <div class="drawer drawer-open">
      <input id="my-drawer-4" type="checkbox" class="drawer-toggle" />
      <div class="drawer-content">
        <main>
          <RouterView />
        </main>
      </div>

      <div class="drawer-side is-drawer-close:overflow-visible">
        <label
          for="my-drawer-4"
          aria-label="close sidebar"
          class="drawer-overlay"
        ></label>
        <div
          class="is-drawer-close:w-16 is-drawer-open:w-64 bg-base-200 flex flex-col items-start min-h-full"
        >
          <ul class="menu w-full grow">
            <li>
              <SideBarItem label="Homepage" @click="goToHome">
                <template #icon>
                  <HomeIcon />
                </template>
              </SideBarItem>
            </li>
            <li>
              <SideBarItem label="Overview" @click="goToOverview">
                <template #icon>
                  <DashboardIcon />
                </template>
              </SideBarItem>
            </li>
             <li>
              <SideBarItem label="Add Club" @click="goToAddClub">
                <template #icon>
                  <AddIcon />
                </template>
              </SideBarItem>
            </li>
            <li v-if="authStore.isLoggedIn">
              <SideBarItem label="Profile" @click="goToProfile">
                <template #icon>
                  <ProfileIcon />
                </template>
              </SideBarItem>
            </li>
            <div v-else></div>
            <li v-if="authStore.isLoggedIn">
              <SideBarItem label="Logout" @click="authStore.logout">
                <template #icon>
                  <LogoutIcon />
                </template>
              </SideBarItem>
            </li>
            <li v-else>
              <SideBarItem label="Login" @click="goToLogin">
                <template #icon>
                  <LoginIcon />
                </template>
              </SideBarItem>
            </li>

            <li>
              <SideBarItem label="Setting" @click="goToSettings">
                <template #icon>
                  <SettingIcon />
                </template>
              </SideBarItem>
            </li>
          </ul>

          <!-- button to open/close drawer -->
          <div
            class="m-2 is-drawer-close:tooltip is-drawer-close:tooltip-right"
            data-tip="Open"
          >
            <label
              for="my-drawer-4"
              class="btn btn-ghost btn-circle drawer-button is-drawer-open:rotate-y-180"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                stroke-linejoin="round"
                stroke-linecap="round"
                stroke-width="2"
                fill="none"
                stroke="currentColor"
                class="inline-block size-4 my-1.5"
              >
                <path
                  d="M4 4m0 2a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2z"
                ></path>
                <path d="M9 4v16"></path>
                <path d="M14 10l2 2l-2 2"></path>
              </svg>
            </label>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
