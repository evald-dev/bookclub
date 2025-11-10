<script setup>
import { useAuthStore } from "../stores/auth";
const authStore = useAuthStore();

import { ref, computed } from "vue";

// Reaktive Daten für das Benutzerprofil
const user = ref({
  name: authStore.currentUser.username,
  activeSince: "March 2024",
  totalBooks: 28,
  goal: 30,
  // profilePic: '...' // Bild-URL ist direkt im <img>-Tag
});

// Berechnete Eigenschaft für die Breite des Fortschrittsbalkens
const progressWidth = computed(() => {
  return (user.value.totalBooks / user.value.goal) * 100 + "%";
});

// Daten für die "Active books"-Sektion
// Wir verwenden 3 identische Bücher, wie im Bild
const activeBooks = ref([
  { id: 1, title: "The Art of War", author: "Sun Tzu" },
  { id: 2, title: "The Art of War", author: "Sun Tzu" },
  { id: 3, title: "The Art of War", author: "Sun Tzu" },
]);

// Daten für die "Upcoming meetings"-Sektion
const meetings = ref([
  {
    id: 1,
    club: "BOOKowki Club",
    nextMeeting: "July 6, 2025 at 12:00",
    task: "The art of War till Chapter 10",
    going: true, // Steuert den Button-Stil
  },
  {
    id: 2,
    club: "literaly me",
    nextMeeting: "July 16, 2025 at 18:00",
    task: "Animals Farm till chapter 5",
    going: false, // Steuert den Button-Stil
  },
]);
</script>

<template>
  <div class="min-h-screen p-6 md:p-10 colo">
    <div class="max-w-6xl mx-auto">
      <div class="grid grid-cols-1 md:grid-cols-3 gap-8 md:gap-12">
        <div class="md:col-span-2 flex flex-col gap-10">
          <section
            class="flex flex-col sm:flex-row items-start sm:items-center gap-6"
          >
            <div class="relative flex-shrink-0">
              <img
                class="w-24 h-24 rounded-full object-cover border-4 border-white shadow-lg"
                src="https://images.unsplash.com/photo-1522163182402-d31518864902?w=100&h=100&fit=crop&crop=faces"
                alt="Profilbild von Boris Razor"
              />
              <span
                class="absolute bottom-0 left-1/2 w-10 h-7 bg-yellow-400 text-yellow-900 text-sm font-bold flex items-center justify-center rounded-md transform -translate-x-1/4 translate-y-2 border-2 border-white shadow-sm"
              >
                20
              </span>
            </div>

            <div class="w-full">
              <div class="flex items-center gap-2 mb-1">
                <h1 class="text-3xl font-bold">{{ user.name}}</h1>
                <PencilIcon
                  class="w-6 h-6 hover:text-stone-800 cursor-pointer"
                />
              </div>

              <p class="text-sm text-stone-600">Active since 1998</p>
              <p class="text-sm text-stone-600">
                {{ user.totalBooks }} Books in total
              </p>

              <div class="mt-4">
                <div
                  class="flex justify-between text-sm font-medium text-stone-700 mb-1"
                >
                  <span>Next goal: {{ user.goal }} Books</span>
                  <span>{{ user.totalBooks }}/{{ user.goal }}</span>
                </div>
                <div class="w-full bg-gray-200 rounded-full h-2.5 shadow-inner">
                  <div
                    class="bg-gradient-to-r from-accent to-primary h-2.5 rounded-full transition-all duration-500"
                    :style="{ width: progressWidth }"
                  ></div>
                </div>
              </div>
            </div>
          </section>

          <section>
            <h2 class="text-2xl font-bold text-stone-900 mb-4">Active books</h2>
            <div class="flex flex-wrap gap-5">
              <div
                v-for="book in activeBooks"
                :key="book.id"
                class="w-36 h-56 bg-red-900 rounded-lg shadow-lg p-4 flex flex-col justify-between text-orange-100 hover:shadow-xl hover:-translate-y-1 transition-all cursor-pointer"
              >
                <div class="font-serif text-lg tracking-wider">
                  <p>THE ART</p>
                  <p>OF WAR</p>
                </div>
                <svg
                  class="w-full h-16 text-orange-200 opacity-30"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="1"
                    d="M12 6.253v11.494m0 0L9.5 14.128M12 17.747l2.5-3.619M6.253 12h11.494M17.747 12L14.128 9.5m3.619 2.5L14.128 14.5"
                  ></path>
                </svg>
                <p class="font-serif text-sm text-center tracking-widest">
                  SUN TZU
                </p>
              </div>
            </div>
          </section>
        </div>

        <div class="md:col-span-1">
          <h2 class="text-2xl font-bold text-stone-900 mb-4">
            Upcoming meetings
          </h2>

          <div class="flex flex-col gap-6">
            <div
              v-for="meeting in meetings"
              :key="meeting.id"
              :class="[
           
              ]"
            >
              <div class="card bg-base-300 w-96 shadow-sm">
                <figure class="px-10 pt-10"></figure>
                <div class="card-body items-center text-center">
                  <h1 class="card-title">{{ meeting.club }}</h1>
                  <h2>Next meeting</h2>
                  <p>{{ meeting.nextMeeting }}</p>
                  <p></p>
                  <p>Read</p>
                  <p>{{ meeting.task }}</p>
                  <div class="card-actions">
                    <button class="btn btn-accent">Im going</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
